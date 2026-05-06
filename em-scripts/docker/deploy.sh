#!/bin/bash
# education management - Docker 一键部署脚本
# 使用方法:
#   ./deploy.sh dev   # 仅启动开发环境中间件 (MySQL/Redis/Nacos/Kafka)
#   ./deploy.sh test  # 启动测试环境完整服务 (中间件 + 全部前后端应用)
#   ./deploy.sh       # 默认 test
#
# 注意: Nacos 配置推送由 code-tool 的 Deploy Nacos 步骤通过 OpenAPI 完成,
#       本脚本只负责拉起容器, 不再调用 init-nacos.sh.

set -e

ENV="${1:-test}"
COMPOSE_FILE="docker-compose-${ENV}.yml"

SCRIPT_DIR="$(cd "$(dirname "$0")" && pwd)"

if [ ! -f "$SCRIPT_DIR/$COMPOSE_FILE" ]; then
    echo "Compose file not found: $COMPOSE_FILE"
    echo "Usage: $0 [dev|test]"
    exit 1
fi

echo "=============================="
echo "  education management Docker Deploy [$ENV]"
echo "  using $COMPOSE_FILE"
echo "=============================="

cd "$SCRIPT_DIR"

if [ "$ENV" = "test" ]; then
    # Step 1: Maven 构建 (使用 docker profile)
    echo ""
    echo "[Step 1/3] Building Java services with Maven..."
    (cd "$SCRIPT_DIR/../../../education-management/em-server" && mvn clean package -P${ENV} -DskipTests)
    echo "Maven build completed."

    # Step 2: Docker Compose 构建镜像
    echo ""
    echo "[Step 2/3] Building Docker images..."
    docker-compose -f "$COMPOSE_FILE" build
    echo "Docker images built."
fi

# Step 3: 启动中间件 (+ test 环境下的应用服务)
echo ""
echo "[Step 3/3] Starting middleware services..."
docker-compose -f "$COMPOSE_FILE" up -d mysql redis kafka
echo "Waiting for MySQL to be ready..."
sleep 15
docker-compose -f "$COMPOSE_FILE" up -d nacos
echo "Waiting for Nacos to be ready..."
sleep 20

if [ "$ENV" = "test" ]; then
    echo "Starting application services..."
    docker-compose -f "$COMPOSE_FILE" up -d
fi

echo ""
echo "=============================="
echo "  Containers started!"
echo "  Run 'Deploy Nacos' from code-tool to push configs."
echo "=============================="
echo ""
echo "Service URLs:"
echo "  - Nacos Console: http://localhost:8848/nacos  (nacos/nacos)"
if [ "$ENV" = "test" ]; then
    echo "  - PC Web:        http://localhost:${PC_WEB_PORT:-8080}"
    echo "  - Mobile Web:    http://localhost:${MOBILE_WEB_PORT:-8081}"
    echo "  - Gateway:       http://localhost:5003"
fi
echo ""
echo "Useful commands:"
echo "  docker-compose -f $COMPOSE_FILE ps       # 查看服务状态"
echo "  docker-compose -f $COMPOSE_FILE logs -f  # 查看日志"
echo "  docker-compose -f $COMPOSE_FILE down     # 停止所有服务"
echo "  docker-compose -f $COMPOSE_FILE down -v  # 停止并删除数据卷"

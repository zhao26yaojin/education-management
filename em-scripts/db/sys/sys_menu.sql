TRUNCATE TABLE sys_menu;

INSERT INTO sys_menu VALUES (2, 'Home', null, '02,', '', ''), (3, '讲师管理', 2, '02,03,', '', ''), (4, '讲师列表', 3, '02,03,04,', '/teacher/list', 'TeacherList'), (5, '编辑讲师', 3, '02,03,05,', '/teacher/edit', 'TeacherEdit'), (6, '课程管理', 2, '02,06,', '', ''), (7, '课程列表', 6, '02,06,07,', '/course/list', 'CourseList'), (8, '信息', 6, '02,06,08,', '', ''), (9, '课程详情', 8, '02,06,08,09,', '/course/info/detail', 'InfoDetail'), (10, 'Login模块', null, '010,', '/login', 'Login'), (11, 'Register模块', null, '011,', '/register', 'Register');


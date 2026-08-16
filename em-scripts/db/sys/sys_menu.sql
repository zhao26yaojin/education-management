TRUNCATE TABLE sys_menu;

INSERT INTO sys_menu VALUES (2, '讲师管理', null, '02,', '', ''), (3, '讲师列表', 2, '02,03,', '/teacher/list', 'teacher/TeacherList'), (4, '编辑讲师', 2, '02,04,', '/teacher/edit', 'teacher/TeacherEdit'), (5, '课程管理', null, '05,', '', ''), (6, '课程列表', 5, '05,06,', '/course/list', 'course/CourseList'), (7, '信息', 5, '05,07,', '', ''), (8, '课程详情', 7, '05,07,08,', '/course/info/detail', 'course/info/InfoDetail');


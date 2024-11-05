# Course Selection System

## 项目概述
本项目是一个前后端分离的选课系统，学生可以在线查看和选择课程，管理员可以进行课程管理和学生管理。系统采用前后端分离架构：
- 前端使用 `Vue`、`Axios` 和 `ElementUI`
- 后端使用 `Spring Boot` 和 `MyBatis`
- 数据库为 `MySQL`

---

## 项目结构

```
Course-Selection-System/
├── Front-End-Code/     # 前端代码（Vue）
├── Back-End-Code/      # 后端代码（Spring Boot）
└── .gitattributes      # Git 属性配置文件
```

---

## 技术栈

### 前端
- **框架**：Vue.js
- **HTTP 请求库**：Axios
- **UI 组件库**：ElementUI

### 后端
- **框架**：Spring Boot
- **持久层框架**：MyBatis
- **数据库**：MySQL

---

## 功能说明

- **学生功能**：
  - 用户注册和登录
  - 查看课程列表
  - 选择课程、退选课程
  - 查看已选课程

- **教师功能**：
  - 用户注册和登录
  - 查看课程列表
  - 创建课程、删除课程
  - 查看选课学生列表

- **管理员功能**：
  - 管理学生信息
  - 增删改查课程信息
  - 查看选课情况统计

---

## 安装与运行

### 1. 克隆项目

```bash
git clone https://github.com/你的用户名/course-selection-system.git
cd course-selection-system
```

### 2. 数据库配置


在 `/Back-End-Code/src/main/resources/application.properties` 中配置你的 MySQL 数据库连接信息：

   ```properties
   spring.datasource.url=jdbc:mysql://localhost:3306/你的数据库名?useSSL=false&serverTimezone=UTC
   spring.datasource.username=你的用户名
   spring.datasource.password=你的密码
   ```

### 3. 后端启动

1. 进入后端代码目录：

   ```bash
   cd Back-End-Code
   ```

2. 使用 Maven 构建并运行 Spring Boot 应用：

   ```bash
   mvn spring-boot:run
   ```

### 4. 前端启动

1. 进入前端代码目录：

   ```bash
   cd Front-End-Code
   ```

2. 安装依赖并启动前端项目：

   ```bash
   npm install
   npm run serve
   ```

3. 前端项目默认运行在 `http://localhost:8080`，可以在浏览器中访问。

---

## API 文档

后端提供了 RESTful API 接口：

### 登录接口
- URL: `/api/login`
- 方法: `POST`
- 参数：
  - `username`: 用户名
  - `password`: 密码

### 查询课程接口
- URL: `/api/courses`
- 方法: `GET`
- 返回：
  ```json
  [
    {
      "courseId": 1,
      "courseName": "数据结构",
      "teacher": "张三"
    },
    ...
  ]
  ```

更多接口详情可以参考后端代码中的注释。

---

## 项目架构

```
+-------------------+      +-------------------+      +---------------------+
|     前端(Vue)      | <--> |   后端(Spring Boot) | <--> |    数据库(MySQL)     |
+-------------------+      +-------------------+      +---------------------+
```

- **前端**：使用 Vue.js 构建用户界面，调用后端 API 展示和操作数据。
- **后端**：使用 Spring Boot 提供 API 服务，MyBatis 处理数据库操作。
- **数据库**：MySQL 用于存储用户、课程和选课信息。

---

## 贡献指南

欢迎贡献代码！请按照以下步骤进行：

1. Fork 本仓库。
2. 创建一个新的分支：`git checkout -b feature/你的功能名称`。
3. 提交修改：`git commit -m '描述你的修改'`。
4. 推送到远程分支：`git push origin feature/你的功能名称`。
5. 创建一个 Pull Request。

---

## 许可证

本项目使用 [MIT 许可证](https://opensource.org/licenses/MIT)。你可以自由地使用、修改和分发本项目。

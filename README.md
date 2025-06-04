# ITCEN SemiProject

[![deploy ec2 semiproject](https://github.com/Bzeromo/ITCEN_semi_project/actions/workflows/deploy_semiproject.yml/badge.svg)](https://github.com/Bzeromo/ITCEN_semi_project/actions/workflows/deploy_semiproject.yml)
---

## **🎯 프로젝트 개요**

  Spring Boot 3.x 기반의 BFF(Backend for Frontend) 아키텍처를 사용한 웹 게시판 애플리케이션

---

### 📋 **주요 기능**

- 🔐 **회원 관리**: 회원가입, 로그인, 회원정보 관리


- 📄 **게시판**: 글 작성, 목록 조회, 상세 조회, 수정, 삭제


- 🎨 **프론트엔드**: Thymeleaf + JavaScript Fetch API


- 🔒 **보안**: Spring Security, JWT 기반 인증/인가


- 🚀 **배포**: GitHub Actions + EC2 자동 배포

---

### 🛠 **기술 스택**
- **Backend**	        Spring Boot 3.x, Spring Security, Spring Data JPA


- **Database**	        PostgreSQL 15, MyBatis


- **Frontend**	        Thymeleaf, Bootstrap 5, JavaScript (Fetch API)


- **Build Tool**	        Maven


- **Deployment**	EC2, Nginx, GitHub Actions

---

### **기능 구성**

- 회원 가입 및 로그인, 나의 정보


- 게시판 CRUD (작성, 목록, 조회, 수정, 삭제, 댓글)


- 갤러리 CRUD (작성, 목록, 조회, 이미지 업로드, CDN)


- JWT 기반 인증

---

### 디렉토리 구성

```
src/
├── main/
│   ├── java/
│   │   └── com/
│   │       └── example/
│   │           └── itcen_semi_project/
│   │               ├── ItcenSemiprojectApplication.java
│   │               ├── config/
│   │               │   ├── SecurityConfig.java
│   │               │   ├── JpaConfig.java
│   │               │   └── MyBatisConfig.java
│   │               ├── auth/                    # 인증/인가 기능
│   │               │   ├── controller/
│   │               │   │   ├── AuthApiController.java
│   │               │   │   └── AuthController.java
│   │               │   ├── service/
│   │               │   │   └── AuthService.java
│   │               │   ├── repository/
│   │               │   │   └── RefreshTokenRepository.java
│   │               │   ├── dto/
│   │               │   │   ├── LoginRequest.java
│   │               │   │   ├── SignupRequest.java
│   │               │   │   └── AuthResponse.java
│   │               │   └── security/
│   │               │       ├── JwtTokenProvider.java
│   │               │       └── JwtAuthenticationFilter.java
│   │               ├── user/                    # 사용자 관리 기능
│   │               │   ├── controller/
│   │               │   │   ├── UserApiController.java
│   │               │   │   └── UserController.java
│   │               │   ├── service/
│   │               │   │   └── UserService.java
│   │               │   ├── repository/
│   │               │   │   ├── jpa/
│   │               │   │   │   └── UserRepository.java
│   │               │   │   └── mybatis/
│   │               │   │       └── UserMapper.java
│   │               │   ├── entity/
│   │               │   │   └── User.java
│   │               │   └── dto/
│   │               │       ├── UserProfileRequest.java
│   │               │       ├── UserResponse.java
│   │               │       └── PasswordChangeRequest.java
│   │               ├── board/                   # 게시판 기능
│   │               │   ├── controller/
│   │               │   │   ├── BoardApiController.java
│   │               │   │   └── BoardController.java
│   │               │   ├── service/
│   │               │   │   └── BoardService.java
│   │               │   ├── repository/
│   │               │   │   ├── jpa/
│   │               │   │   │   └── BoardRepository.java
│   │               │   │   └── mybatis/
│   │               │   │       └── BoardMapper.java
│   │               │   ├── entity/
│   │               │   │   └── Board.java
│   │               │   └── dto/
│   │               │       ├── BoardRequest.java
│   │               │       ├── BoardResponse.java
│   │               │       ├── BoardListResponse.java
│   │               │       └── BoardSearchRequest.java
│   │               ├── common/                  # 공통 기능
│   │               │   ├── controller/
│   │               │   │   └── HomeController.java
│   │               │   ├── dto/
│   │               │   │   ├── ApiResponse.java
│   │               │   │   └── PageResponse.java
│   │               │   ├── exception/
│   │               │   │   ├── GlobalExceptionHandler.java
│   │               │   │   ├── BusinessException.java
│   │               │   │   └── ErrorCode.java
│   │               │   └── util/
│   │               │       ├── SecurityUtils.java
│   │               │       └── DateUtils.java
│   │               └── shared/                  # 공유 엔티티/설정
│   │                   ├── entity/
│   │                   │   └── BaseEntity.java
│   │                   └── config/
│   │                       └── DatabaseConfig.java
│   └── resources/
│       ├── application.properties
│       ├── application-dev.properties
│       ├── application-prod.properties
│       ├── static/
│       │   ├── css/
│       │   ├── js/
│       │   │   ├── auth/
│       │   │   │   ├── login.js
│       │   │   │   └── signup.js
│       │   │   ├── user/
│       │   │   │   └── profile.js
│       │   │   └── board/
│       │   │       ├── list.js
│       │   │       ├── detail.js
│       │   │       └── form.js
│       │   └── images/
│       ├── templates/
│       │   ├── layout/
│       │   │   ├── base.html
│       │   │   └── fragments/
│       │   ├── auth/
│       │   │   ├── login.html
│       │   │   └── signup.html
│       │   ├── user/
│       │   │   └── profile.html
│       │   └── board/
│       │       ├── list.html
│       │       ├── detail.html
│       │       ├── write.html
│       │       └── edit.html
│       └── mapper/
│           ├── user/
│           │   └── UserMapper.xml
│           └── board/
│               └── BoardMapper.xml
├── pom.xml
└── README.md
```

---

### 프로파일에 따른 실행방법

```shell
# 개발 모드 실행
.\mvnw spring-boot:run

# 프로덕션 빌드
.\mvnw clean package

# 운영 모드 실행
java -jar .\target\ITCEN_semi_project-0.0.1-SNAPSHOT.jar --spring.profiles.active=prod
```
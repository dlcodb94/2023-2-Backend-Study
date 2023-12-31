### 1. DB
여러 사용자가 공유하여 사용할 수 있도록 통합해서 저장한 운영 데이터의 집합으로, 데이터를 조직화하면 데이터에 의미가 생기고, 대량의 데이터를 효율적으로 관리할 수 있다.
이러한 데이터베이스를 만들고 관리하는 방식 중 대표적으로 SQL과 NoSQL이 있다.

##### 1.1 SQL
관계형 데이터베이스, RDB (Relational DataBase)로 다음과 같은 특징을 갖는다.
- 데이터는 정해진 데이터 스키마에 따라 테이블에 저장되며 스키마를 준수하지 않은 레코드는 테이블에 추가할 수 없다.

*스키마 : 데이터베이스의 구조에 관한 메타 데이터(명세)*
- 데이터는 관계를 통해 여러 테이블에 분산된다.
- 중복 데이터는 저장하지 않는다(무결성 보장)

**수정이 빈번하고, 구조와 중요도가 높을 경우 사용**
(ex) MySQL, MsSQL, 오라클

##### 1.2 NoSQL
SQL이 아닌 데이터베이스로 다음과 같은 특징을 갖는다.
- 스키마도 없고 관계도 없는 자료 형식이다.
- 관련 데이터를 동일한 ‘컬렉션’에 넣는다.

**NoSQL은 구조가 유연하여 확장이 편리하고 속도가 빠름**
(ex) MongoDB, Redis




***
### 2. ORM(Object-Relational Mapping)
##### 2.1 ORM 정의
데이터베이스와 객체 지향 프로그래밍 언어 사이의 관계형 데이터를 객체로 매핑하는 기술이나 프로그래밍 기술로, 객체를 데이터베이스의 데이터 형식으로 바꿔 저장해주는 역할을 한다. SQL을 작성하지 않아도 데이터를 조작할 수 있다는 장점이 있다.
(ex) Hibernate, EclipseLink, DataNucleus 

*Entity : 데이터베이스에 넣을 객체*

##### 2.2 ORM의 장단점
장점
- 추상화 : 데이터베이스와의 상호 작용을 객체 지향적인 방식으로 처리할 수 있다.
- 데이터베이스 독립성 : 다양한 데이터베이스 시스템에 대해 동일한 코드를 사용할 수 있게 도와준다.
- 생산성 : SQL 쿼리를 직접 작성하지 않아도 된다.
- 유지 보수 : 코드 변경이 필요할 때, 객체 모델만 수정하면 된다.

단점
- 성능 : 개발자가 작성한 쿼리보다 비효율적일 수 있다.
- 복잡성 : 복잡한 쿼리나 특정 데이터베이스 최적화 기술을 사용하려면 ORM을 벗어나야 할 수 있다.






***
### 3. JPA(Java Persistence API)
##### 3.1 JPA의 정의
주로 Spring에서 많이 사용하지만, 자바 애플리케이션에서 **관계형 데이터베이스**를 사용하는 방법을 정의한 자바 API 이다. 자바 ORM 기술에 대한 표준 사양으로, 객체와 데이터베이스 테이블 간의 매핑을 처리한다.

##### 3.2 JPA의 특징
- 객체-테이블 매핑 : 어노테이션 또는 XML을 사용하여 자바 객체와 데이터베이스 테이블을 매핑함. ERD (Entity-Relation Diagram)을 사용하여 Entity 간의 관계를 기반으로 다양한 정보를 저장한다. ERD에는 데이터베이스의 구조에 관한 메타 데이터, 명세를 적는다.
    - 객체의 관계
        - 1:1 (@OneToOne) 양방향 접근 가능
        - 1:N (@OneToMany : @ManyToOne)
        - M:N (@ManyToMany) 정보 추가가 불가능하므로 실무에서 사용하지 않는다.

- 쿼리 언어 사용 : JPQL (Java Persistence Query Language)라는 객체지향 쿼리 언어를 제공하여 데이터베이스에 질의할 수 있음 
- 생명주기 관리 : 엔티티의 생명 주기 (예: 생성, 조회, 수정, 삭제)를 관리함
- 캐싱 : 기본적인 캐시 전략을 지원함
- 자동 스키마 생성: 데이터베이스 스키마를 자동으로 생성하거나 업데이트 할 수 있음

JPA는 위와 같은 특성을 영속성 컨텍스트(Entity 를 영구 저장하는 환경)를 이용하여 구현한다.

*영속성 컨텍스트: 애플리케이션과 데이터베이스 사이에서 객체를 보관하는 가상의 데이터베이스 같은 역할을 한다. 엔티티 매니저를 통해 엔티티를 저장하거나 조회하면 엔티티 매니저는 영속성 컨텍스트에 엔티티를 보관하고 관리한다.*

##### 3.3 Spring Data JPA
Spring Framework의 일부로, 데이터 접근 계층을 쉽게 구현할 수 있도록 지원하는 모듈이다. 복잡한 설정이나 쿼리 없이도 빠르고 편리하게 데이터 접근 계층을 구현할 수 있어, 개발 생산성이 크게 향상될 수 있다.

- Repository 인터페이스 : Repository 인터페이스를 사용하여 CRUD (Create, Read, Update, Delete) 연산을 추상화함. 개발자는 이 인터페이스를 상속받아 필요한 메서드를 선언하기만 하면 됨
- 쿼리 메서드 : 메서드 이름을 분석하여 자동으로 SQL 쿼리를 생성하는 기능을 제공
- Custom Query : @Query 애노테이션을 사용하여 사용자 정의 쿼리를 작성
- Pagination and Sorting : 페이징과 정렬 기능을 지원
- Transaction Management : 트랜잭션을 관리

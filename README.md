# 액추에이터(Actuator)

    액추에이터(Actuator)는 HTTP 엔드포인트나 JMX(Java management Extensions)를 활용해 
    애플리케이션을 모니터링하고 관리할 수 있는 기능을 제공합니다.

    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-actuator</artifactId>
        <version>3.3.3</version>
    </dependency>

# 액추에이터(Actuator) 링크 목록

    management.endpoints.web.exposure.include=*
    http://localhost:8080/actuator
    http://localhost:8080/actuator/info
    http://localhost:8080/actuator/beans
    http://localhost:8080/actuator/env
    http://localhost:8080/actuator/loggers
    
# 액추에이터(Actuator) 내용 추가
    public class CustomInfoContributor implements InfoContributor {
        @Override
        public void contribute(Info.Builder builder) {
            Map<String, Object> content = new HashMap<>();
    
            content.put("code-info", "정보 추가");
            builder.withDetail("custom-info-contributor", content);
        }
    }

# 사용자 정의 액추에이터(Actuator)

    @Component
    @Endpoint(id = "note", enableByDefault = true)
    public class NoteEndpoint {
    }

    호출(GET)
    http://localhost:8080/actuator/note
    
    노트 작성(POST)
    http://localhost:8080/actuator/note
    {
        "key": "test",
        "value": "some test"
    }

    노트 삭제(DELETE)
    http://localhost:8080/actuator/note?key=test

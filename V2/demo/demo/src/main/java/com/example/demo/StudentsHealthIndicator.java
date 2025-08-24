package com.example.demo;



import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.stereotype.Component;

@Component
public class StudentsHealthIndicator implements HealthIndicator {

    private final StudentRepo repo;

    public StudentsHealthIndicator(StudentRepo repo) {
        this.repo = repo;
    }

    @Override
    public Health health() {
        try {
            long count = repo.count();
            return Health.up()
                    .withDetail("studentCount", count)
                    .build();
        } catch (Exception e) {
            return Health.down(e).build();
        }
    }
}


package com.example.issue.Repository;

import com.example.issue.entity.Issue;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IssueRepository extends JpaRepository<Issue,Long> { //<entity,entity tipini>

}

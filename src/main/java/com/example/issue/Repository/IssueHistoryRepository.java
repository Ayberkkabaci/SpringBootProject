package com.example.issue.Repository;
import com.example.issue.entity.IssueHistory;
import org.springframework.data.jpa.repository.JpaRepository;
public interface IssueHistoryRepository extends JpaRepository<IssueHistory,Long> {
}

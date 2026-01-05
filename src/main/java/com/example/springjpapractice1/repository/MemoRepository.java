package com.example.springjpapractice1.repository;

import com.example.springjpapractice1.entity.Memo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemoRepository extends JpaRepository<Memo, Long> {
}

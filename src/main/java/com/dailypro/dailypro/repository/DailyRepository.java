package com.dailypro.dailypro.repository;

import com.dailypro.dailypro.dto.DailyDto;
import com.dailypro.dailypro.entity.Daily;
import org.hibernate.sql.ast.tree.expression.JdbcParameter;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DailyRepository extends JpaRepository<Daily,Long> {

}

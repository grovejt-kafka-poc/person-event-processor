package com.dsths.kafkapoc.personeventprocessor.member;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;


public interface MemberRepository extends JpaRepository<Member, Long>{


}

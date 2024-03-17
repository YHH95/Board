package com.example.community.repository;

import com.example.community.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface MemberRepository extends JpaRepository<Member, Long> {


    public Member findAllById(String id);
    public Member findAllByName(String name);
    public Member findAllByAddress(String address);


    @Query(value = "select * from member", nativeQuery = true)
    public List<Member> memSelectAll();

    @Query(value = "select * from member where mno = :mno", nativeQuery = true)
    public Optional<Member> memSelectOne(Long mno);


    @Query(value = "update member set pw = :pw , name = :name , address = :address , birthdate = :birthdate where mno = :mno", nativeQuery = true)
    public void memModify(Long mno, String pw, String name, String address, String birthdate);


    @Query(value = "delete from member where mno = :mno", nativeQuery = true)
    public void memDelete(Long mno);


}

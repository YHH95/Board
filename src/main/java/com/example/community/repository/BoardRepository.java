package com.example.community.repository;

import com.example.community.entity.Board;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface BoardRepository extends JpaRepository<Board, Long> {


    public Board findAllByTitle(String title);
    public Board findAllByContent(String content);
    public Board findAllByWriter(String writer);


    @Query(value = "select * from board", nativeQuery = true)
    public List<Board> boardSelectAll();

    @Query(value = "select * from board where bno = :bno", nativeQuery = true)
    public Optional<Board> boardSelectOne(Long bno);

    @Query(value = "update board set title = :title, content = :content, writer = :writer where bno = :bno", nativeQuery = true)
    public void boardUpdate(Long bno, String title, String content, String writer);

    @Query(value = "delete from board where bno = :bno" , nativeQuery = true)
    public void boardDelete(Long bno);
}

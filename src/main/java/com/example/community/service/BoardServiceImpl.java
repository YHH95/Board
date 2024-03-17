package com.example.community.service;


import com.example.community.dto.BoardDTO;
import com.example.community.dto.PageRequestDTO;
import com.example.community.entity.Board;
import com.example.community.repository.BoardRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;


@Service
@Log4j2
@RequiredArgsConstructor
@Transactional
public class BoardServiceImpl implements BoardService{

    private final BoardRepository boardRepository;
    private final ModelMapper modelMapper;

    @Override
    public Long register(BoardDTO boardDTO) {

        Board board = modelMapper.map(boardDTO,Board.class);

        Long bno = boardRepository.save(board).getBno();

        return bno;
    }

    @Override
    public PageRequestDTO<BoardDTO> list(PageRequestDTO pageRequestDTO) {
        return null;
    }


}



















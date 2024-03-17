package com.example.community.service;

import com.example.community.dto.BoardDTO;
import com.example.community.dto.PageRequestDTO;

public interface BoardService {


    public Long register(BoardDTO boardDTO);

    PageRequestDTO<BoardDTO> list(PageRequestDTO pageRequestDTO);

}

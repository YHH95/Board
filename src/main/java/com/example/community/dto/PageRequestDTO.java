package com.example.community.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class PageRequestDTO {

    //컨트롤러에서 값을 받을 때 각종 정보를 전부 받는 객체

    @Builder.Default
    private int page = 1;
    @Builder.Default
    private int size = 10;

    private String type; //검색 종류에 t,c,w,tc,tcw

    private String keyword; //검색어

    private String link;

    public String[] getTypes(){ //문자열type를 배열로 변환
        if (type == null || type.isEmpty()){
            return null;
        }
        return type.split("");
    }

    public Pageable getPageable(String... props){
        return PageRequest.of(this.page-1,this.size,Sort.by(props).descending());
    }

    public String getLink(){
        if(link == null){
            StringBuilder builder = new StringBuilder();
            builder.append("page="+this.page);
            if(type != null && type.length()>0){
                builder.append("&type="+type);
            }
            if(keyword != null){
                try{
                    builder.append("&keyword="+ URLEncoder.encode(keyword,"utf-8"));
                }catch (UnsupportedEncodingException e){
                    e.printStackTrace();
                }
            }

            link = builder.toString(); //page=3&type=t&keyword=신짱구
        }
        return link;
    }
}
package com.spring.erica.springboot.web;

import com.spring.erica.springboot.service.posts.PostsService;
import com.spring.erica.springboot.web.dto.PostsResponseDto;
import com.spring.erica.springboot.web.dto.PostsSaveRequestDto;
import com.spring.erica.springboot.web.dto.PostsUpdateRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController  //컨트롤러를 JSON을 반환하는 컨트롤러로 만들어줌
public class PostsApiController {
    private final PostsService postsService;

    @PostMapping("/api/v1/posts")
    public Long save(@RequestBody PostsSaveRequestDto requestDto) {
        return postsService.save(requestDto);
    }

    @PutMapping("/api/v1/posts/{id}")
    public Long update(@PathVariable Long id, @RequestBody PostsUpdateRequestDto requestDto) {
        return postsService.update(id, requestDto);
    }

    @GetMapping("/api/v1/posts/{id}")
    public PostsResponseDto findById(@PathVariable Long id){
        return postsService.findById(id);
    }
}

package com.example.springjpapractice1.controller;

import com.example.springjpapractice1.dto.MemoRequestDto;
import com.example.springjpapractice1.dto.MemoResponseDto;
import com.example.springjpapractice1.entity.Memo;
import com.example.springjpapractice1.repository.MemoRepository;
import lombok.RequiredArgsConstructor;
import org.jspecify.annotations.Nullable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class MemoService {

    private final MemoRepository memoRepository;

    @Transactional
    public MemoResponseDto save(MemoRequestDto dto) {
        Memo memo = new Memo(dto.getTitle(), dto.getContent());
        Memo savedMemo = memoRepository.save(memo);
        return new MemoResponseDto(savedMemo.getId(),savedMemo.getTitle(), savedMemo.getContent());
    }

    @Transactional(readOnly = true)
    public List<MemoResponseDto> findAll() {
        List<Memo> memos = memoRepository.findAll();

        List<MemoResponseDto> dtos = new ArrayList<>();
        for (Memo memo : memos) {
            dtos.add(new MemoResponseDto(memo.getId(), memo.getTitle(), memo.getContent()));
        }
        return dtos;
    }
}

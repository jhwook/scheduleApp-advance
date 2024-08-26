package com.sparta.scheduleappadvance.service;

import com.sparta.scheduleappadvance.dto.UserRequestDto;
import com.sparta.scheduleappadvance.dto.UserResponseDto;
import com.sparta.scheduleappadvance.entity.User;
import com.sparta.scheduleappadvance.repository.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public UserResponseDto createUser(UserRequestDto userRequestDto) {
        User newUser = new User(userRequestDto);

        UserResponseDto response = new UserResponseDto(userRepository.save(newUser));

        return response;
    }

    public UserResponseDto getUser(Long id) {
        UserResponseDto response = new UserResponseDto(findUser(id));

        return response;
    }

    public List<UserResponseDto> getAllUsers() {
        return userRepository.findAll().stream().map(UserResponseDto::new).collect(Collectors.toList());
    }


    @Transactional
    public UserResponseDto updateUser(UserRequestDto userRequestDto, Long id) {
        User user = findUser(id);

        UserResponseDto response = new UserResponseDto(user.update(userRequestDto));

        return response;
    }

    public User findUser(Long id) {
        return userRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("해당 유저는 존재하지 않습니다."));
    }

    @Transactional
    public String deleteUser(Long id) {
        User user = findUser(id);
        userRepository.delete(user);
        return "Successfully deleted";
    }
}

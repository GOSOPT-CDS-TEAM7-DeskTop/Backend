package sopt.org.Pinterest.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import sopt.org.Pinterest.controller.dto.response.SavedPinResponseDto;
import sopt.org.Pinterest.controller.dto.response.UserInfoResponseDto;
import sopt.org.Pinterest.domain.User;
import sopt.org.Pinterest.exception.Error;
import sopt.org.Pinterest.exception.model.NotFoundException;
import sopt.org.Pinterest.infrastructure.UserRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public UserInfoResponseDto getUserInfo(Long userId) {
        User findUser = userRepository.findById(userId)
                .orElseThrow(() -> new NotFoundException(Error.NOT_FOUND_USER_EXCEPTION, Error.NOT_FOUND_USER_EXCEPTION.getMessage()));

        return UserInfoResponseDto.of(findUser);
    }

    public List<SavedPinResponseDto> getSavedPinList(Long userId) {
        User findUser = userRepository.findById(userId)
                .orElseThrow(() -> new NotFoundException(Error.NOT_FOUND_USER_EXCEPTION, Error.NOT_FOUND_USER_EXCEPTION.getMessage()));

        return findUser.getSavedPinList().stream().map(SavedPinResponseDto::of).collect(Collectors.toList());
    }

    @Transactional
    public void followUser(Long followedUserId, Long followingUserId) {
        User followedUser = userRepository.findById(followedUserId)
                .orElseThrow(() -> new NotFoundException(Error.NOT_FOUND_FOLLOWED_USER_EXCEPTION, Error.NOT_FOUND_FOLLOWED_USER_EXCEPTION.getMessage()));

        User followingUser = userRepository.findById(followingUserId)
                .orElseThrow(() -> new NotFoundException(Error.NOT_FOUND_USER_EXCEPTION, Error.NOT_FOUND_USER_EXCEPTION.getMessage()));

        followedUser.addFollower();
        followingUser.addFollowing();
    }
}

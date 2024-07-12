package com.scm.services.implementation;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import com.scm.entities.User;
import com.scm.helper.ResourceNotFoundException;
import com.scm.repositories.UserRepo;
import com.scm.services.UserService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepo userRepository;
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    
    public UserServiceImpl(UserRepo userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User saveUser(User user) {
        String id = UUID.randomUUID().toString();
        user.setUserid(id);
        return userRepository.save(user);
    }

    @Override
    public Optional<User> getUserById(String id) {
        return userRepository.findById(id);
    }

    @Override
    public Optional<User> updateUser(User user) {
        User existingUser = userRepository.findById(user.getUserid())
            .orElseThrow(() -> new ResourceNotFoundException("User not found"));
        
        existingUser.setName(user.getName());
        existingUser.setEmail(user.getEmail());
        existingUser.setPassword(user.getPassword());
        existingUser.setAbout(user.getAbout());
        existingUser.setPhone_number(user.getPhone_number());
        existingUser.setProflePic(user.getProflePic());
        existingUser.setEnabled(user.isEnabled());
        existingUser.setEmailVerified(user.isEmailVerified());
        existingUser.setPhoneVerified(user.isPhoneVerified());
        existingUser.setProvider(user.getProvider());
        existingUser.setProviderId(user.getProviderId());

        userRepository.save(existingUser);
        return Optional.of(existingUser);
    }

    @Override
    public void deleteUser(String id) {
        User existingUser = userRepository.findById(id)
            .orElseThrow(() -> new ResourceNotFoundException("User not found"));
        userRepository.delete(existingUser);
    }

    @Override
    public boolean isUserExist(String id) {
        return userRepository.findById(id).isPresent();
    }

    @Override
    public boolean isUserExistByEmail(String email) {
        return userRepository.findByEmail(email).isPresent();
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }
}

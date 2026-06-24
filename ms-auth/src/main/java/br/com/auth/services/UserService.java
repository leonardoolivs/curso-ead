package br.com.auth.services;

import br.com.auth.dtos.UpdatePasswordRequest;
import br.com.auth.dtos.UserRequest;
import br.com.auth.entities.User;
import br.com.auth.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository repository;

    @Transactional
    public User create(UserRequest request){
        User user = new User();

        BeanUtils.copyProperties(request, user);

        return repository.save(user);
    }

    @Transactional(readOnly = true)
    public List<User> findAll(){
        return repository.findAll();
    }

    @Transactional(readOnly = true)
    public User findById(Long id){
        return repository.findById(id).orElseThrow(() -> new RuntimeException("Not found"));
    }

    @Transactional
    public void delete(Long id){
        repository.deleteById(id);
    }

    @Transactional
    public User update(Long id, User userUpdated){
        User user = repository.findById(id).orElseThrow(() -> new RuntimeException("Not found"));

        BeanUtils.copyProperties(userUpdated, user, "id", "creationDate", "lastUpdateDate");

        return user;
    }

    @Transactional
    public void updatePassword(Long id, UpdatePasswordRequest pass){
        User user = repository.findById(id).orElseThrow(() -> new RuntimeException("Not found"));

        if(pass.getNewPassword().equals(pass.getOldPassword())){
            throw new RuntimeException("New password needs to be different from old password.");
        }

        user.setPassword(pass.getNewPassword());
    }

}

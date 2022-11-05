package com.example.demo;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
class UserController {

    private final UserEntityRepository repository;

    UserController(UserEntityRepository repository) {
        this.repository = repository;
    }


    // Aggregate root
    // tag::get-aggregate-root[]
    @GetMapping("/userentitys")
    List<UserEntity> all() {
        return repository.findAll();
    }
    // end::get-aggregate-root[]

    @PostMapping("/userentitys")
    UserEntity newUserEntity(@RequestBody UserEntity newUserEntity) {
        return repository.save(newUserEntity);
    }

    // Single item

    @GetMapping("/userentitys/{id}")
    UserEntity one(@PathVariable Integer id) {

        return repository.findById(id)
                .orElseThrow(() -> new UserEntityNotFoundException(id));
    }

    @PutMapping("/userentitys/{id}")
    UserEntity replaceUserEntity(@RequestBody UserEntity newUserEntity, @PathVariable Integer id) {

        return repository.findById(id)
                .map(userEntity -> {
                    userEntity.setUserName(newUserEntity.getUserName());
                    return repository.save(userEntity);
                })
                .orElseGet(() -> {
                    newUserEntity.setId(id);
                    return repository.save(newUserEntity);
                });
    }

    @DeleteMapping("/userentitys/{id}")
    void deleteEmployee(@PathVariable Integer id) {
        repository.deleteById(id);
    }
}
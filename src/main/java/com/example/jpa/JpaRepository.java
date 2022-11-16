package com.example.jpa;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JpaRepository extends CrudRepository<User, Integer>{
    // IDの型が基本型の場合はラッパークラスを指定するので、int型ではなくてInteger型にする
}

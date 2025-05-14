package org.example.task5;

public interface CharacterBuilder<T>{
    CharacterBuilder<T> name(String name);
    CharacterBuilder<T> power(int power);
    CharacterBuilder<T> reputation(float reputation);
    CharacterBuilder<T> action(String action);
    T build();
}

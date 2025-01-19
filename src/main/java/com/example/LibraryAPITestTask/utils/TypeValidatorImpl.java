package com.example.LibraryAPITestTask.utils;


import com.example.LibraryAPITestTask.transaction.model.TypeOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class TypeValidatorImpl implements TypeValidator {
    @Override
    public void validator(TypeOperation typeOperation) {
        if (typeOperation != TypeOperation.TAKE && typeOperation != TypeOperation.RETURN) {
            throw new IllegalArgumentException(
                    "Некорректный тип операции: %s. Ожидается: TAKE или RETURN".formatted(typeOperation.name())
            );
        }
    }
}

package be.vdab.services;

import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.annotation.Isolation;


@Retention(RUNTIME)
@Target(TYPE)
@Service
@Transactional(readOnly = true, isolation = Isolation.READ_COMMITTED)
public @interface ReadOnlyTransactionService {

}

package com.example.openapi.api;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import java.util.Optional;
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2023-06-29T16:41:33.878459+03:00[Europe/Moscow]")
@Controller
@RequestMapping("${openapi..base-path:/PRO10022801/api/1.0.0}")
public class QuizzesApiController implements QuizzesApi {

    private final QuizzesApiDelegate delegate;

    public QuizzesApiController(@org.springframework.beans.factory.annotation.Autowired(required = false) QuizzesApiDelegate delegate) {
        this.delegate = Optional.ofNullable(delegate).orElse(new QuizzesApiDelegate() {});
    }

    @Override
    public QuizzesApiDelegate getDelegate() {
        return delegate;
    }

}

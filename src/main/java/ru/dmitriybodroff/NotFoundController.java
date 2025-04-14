package ru.dmitriybodroff;

import io.avaje.http.api.Controller;
import io.avaje.jex.http.Context;
import io.avaje.jex.http.ExceptionHandler;
import io.avaje.jex.http.HttpStatus;
import io.avaje.jex.http.NotFoundException;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import static lombok.AccessLevel.PACKAGE;

@Slf4j
@Controller
@AllArgsConstructor(access = PACKAGE)
final class NotFoundController implements ExceptionHandler<NotFoundException> {

    @Override
    public void handle(final Context ctx, final NotFoundException exception) {
        log.warn("I got into the NotFoundController with context path [{}]!", ctx.fullUrl());
        ctx.status(HttpStatus.NOT_FOUND_404);
        ctx.text("I'm a response of NotFoundController");
    }
}

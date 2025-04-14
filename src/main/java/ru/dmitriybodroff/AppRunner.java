package ru.dmitriybodroff;

import io.avaje.jex.Jex;
import io.avaje.jex.http.ExceptionHandler;
import io.avaje.jex.http.NotFoundException;
import io.avaje.jex.staticcontent.StaticContent;
import jakarta.inject.Singleton;
import lombok.AllArgsConstructor;
import lombok.val;

import static lombok.AccessLevel.PACKAGE;

@Singleton
@AllArgsConstructor(access = PACKAGE)
final class AppRunner {

    private final ExceptionHandler<NotFoundException> notFoundController;

    public void run() {
        val publicContent = StaticContent
                .ofClassPath("/public/")
                .route("/public/")
                .directoryIndex("")
                .build();

        Jex.create()
                .plugin(publicContent)
                .error(NotFoundException.class, this.notFoundController)
                .start();
    }
}

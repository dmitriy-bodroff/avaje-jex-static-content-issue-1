package ru.dmitriybodroff;

import io.avaje.inject.BeanScope;
import lombok.val;

final class Main {

    private Main() {
    }

    public static void main(final String[] args) {
        new Main().run();
    }

    private void run() {
        val beanScope = BeanScope
                .builder()
                .shutdownHook(true)
                .build();
        val appRunner = beanScope.get(AppRunner.class);
        appRunner.run();
    }
}

// "Create local variable 'foo'" "true"
class Foo {
    int x = foo ? 0 : switch(1) {
        default -> {
            break f<caret>oo;
        }
    };
}
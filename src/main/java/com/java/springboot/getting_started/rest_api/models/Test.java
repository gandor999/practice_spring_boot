package com.java.springboot.getting_started.rest_api.models;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Test extends AbstractTest {
    private String testProp = "Hello Test";
}


@Getter
@Setter
class InnerTestRequest extends Test {
}


@Getter
@Setter
abstract class AbstractTest {
    private String abstractTest;
}

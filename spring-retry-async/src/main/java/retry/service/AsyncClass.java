package retry.service;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
public class AsyncClass {
    private RetryableClass retryableClass;

    public AsyncClass(RetryableClass retryableClass) {
        this.retryableClass = retryableClass;
    }

    @Async
    public void retryMethod(){
        retryableClass.retryMethod();
    }
}

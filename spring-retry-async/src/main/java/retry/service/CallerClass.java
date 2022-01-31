package retry.service;

import org.springframework.stereotype.Service;

@Service
public class CallerClass {

    private AsyncClass asyncClass;

    public CallerClass(AsyncClass asyncClass) {
        this.asyncClass = asyncClass;
    }

    public void callRetryableMethodInAsync(){
        asyncClass.retryMethod();
    }
}

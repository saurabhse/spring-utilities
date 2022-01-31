package retry.service;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.retry.annotation.Backoff;
import org.springframework.retry.annotation.Recover;
import org.springframework.retry.annotation.Retryable;
import org.springframework.stereotype.Service;
import retry.exception.CustomException;

import java.util.Optional;

@Service
public class RetryableClass {
    Logger logger = LoggerFactory.getLogger(RetryableClass.class);

    @Retryable(maxAttempts= 3, value = CustomException.class, backoff = @Backoff(delay = 3000))
    public void retryMethod(){
        try{
            logger.info("this is will try for 3 times with delay of 3 sec");
            doSomething();
        }catch(Exception e){
            throw new CustomException(1L,"error");
        }

    }

    @Recover
    private void handleFailedDefaultProfileSend(CustomException exception){
        logger.info("this is called when max tries also failed");
    }

    private void doSomething() throws Exception {
        logger.info("Calling external service or do something else");
        throw new Exception();
    }
}

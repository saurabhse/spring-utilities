package retry.entrypoint;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import retry.service.CallerClass;

@Component
public class RunApplication implements CommandLineRunner {
    @Autowired
    private CallerClass callerClass;

    @Override
    public void run(String...args) throws Exception {
        callerClass.callRetryableMethodInAsync();

    }
}
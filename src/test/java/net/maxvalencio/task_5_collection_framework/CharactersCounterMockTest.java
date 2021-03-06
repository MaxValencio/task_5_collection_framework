package net.maxvalencio.task_5_collection_framework;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import static org.mockito.Mockito.*;
import org.mockito.Spy;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class CharactersCounterMockTest {

	@Spy
	private Cache cache = new CacheImpl();

	@Spy
	private CharactersCounter counter = new CharactersCounterImpl();

	@InjectMocks
	private CharactersCounter proxy = new CharactersCounterProxy();

	@Test
	public void count_callCache() {
		String line = "hello world!";
		for (int i = 0; i < 5; i++) {
			proxy.count(line);
		}
		verify(cache, times(4)).get(line);
		verify(counter).count(line);
	}
}

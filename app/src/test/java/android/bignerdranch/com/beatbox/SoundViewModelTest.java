package android.bignerdranch.com.beatbox;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class SoundViewModelTest {
    private BeatBox beatBox;
    private Sound sound;
    private SoundViewModel subject;

    @Before
    public void setUp() throws Exception {
        beatBox = mock(BeatBox.class);
        sound = new Sound("assetPath");
        subject = new SoundViewModel(beatBox);
        subject.setSound(sound);
    }

    @Test
    public void exposesSoundNameAsTitle() {
        assertThat(subject.getTitle(), is(sound.getName()));
    }

    @Test
    public void callsBeatBoxPlayOnButtonClicked() {
        subject.onButtonClicked();

        verify(beatBox);
        beatBox.play(sound);
    }
}
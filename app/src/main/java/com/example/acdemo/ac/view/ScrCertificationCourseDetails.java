package com.example.acdemo.ac.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.app.Dialog;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.acdemo.R;
import com.example.acdemo.ac.Utils.VideoPlayerConfig;
import com.example.acdemo.ac.communication.Constants;
import com.example.acdemo.ac.model.Courses;
import com.example.acdemo.ac.model.CoursesList;
import com.google.android.exoplayer2.DefaultLoadControl;
import com.google.android.exoplayer2.DefaultRenderersFactory;
import com.google.android.exoplayer2.ExoPlaybackException;
import com.google.android.exoplayer2.ExoPlayerFactory;
import com.google.android.exoplayer2.LoadControl;
import com.google.android.exoplayer2.PlaybackParameters;
import com.google.android.exoplayer2.Player;
import com.google.android.exoplayer2.SimpleExoPlayer;
import com.google.android.exoplayer2.Timeline;
import com.google.android.exoplayer2.source.ExtractorMediaSource;
import com.google.android.exoplayer2.source.MediaSource;
import com.google.android.exoplayer2.source.TrackGroupArray;
import com.google.android.exoplayer2.trackselection.AdaptiveTrackSelection;
import com.google.android.exoplayer2.trackselection.DefaultTrackSelector;
import com.google.android.exoplayer2.trackselection.TrackSelection;
import com.google.android.exoplayer2.trackselection.TrackSelectionArray;
import com.google.android.exoplayer2.trackselection.TrackSelector;
import com.google.android.exoplayer2.ui.PlayerView;
import com.google.android.exoplayer2.upstream.BandwidthMeter;
import com.google.android.exoplayer2.upstream.DataSource;
import com.google.android.exoplayer2.upstream.DefaultAllocator;
import com.google.android.exoplayer2.upstream.DefaultBandwidthMeter;
import com.google.android.exoplayer2.upstream.DefaultDataSourceFactory;
import com.google.android.exoplayer2.util.Util;

import java.util.Objects;

public class ScrCertificationCourseDetails extends AppCompatActivity implements View.OnClickListener, Player.EventListener  {
    private Button bt_buy_course;
    private Courses courses;

    private String TAG = "BROADCAST_HOME_VIDEO_TAG";

    private ProgressBar mSpinnerVideo;
    SimpleExoPlayer player;
    private PlayerView mExoplayerVideoView;

    String videoTitle, videoDescription, videoDescription1, videoUri,right_videoUri, left_videoUri, videoDateTime;

    boolean fullscreen = false;
    ImageView mImgViewFullScreen;
    Intent intent;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scr_certification_course_details);
        getSupportActionBar().setTitle("Certification Course Details");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        initUi();

        courses = CoursesList.getInstance().getSelectedList();
        if (courses.getType().contains(Constants.FREE_COURSE)) {
            bt_buy_course.setVisibility(View.VISIBLE);
            bt_buy_course.setText("Enroll");
        } else  {
            bt_buy_course.setVisibility(View.VISIBLE);
            bt_buy_course.setText("Buy Now");
        }




        /*intent = getIntent();
        right_videoUri = intent.getStringExtra("chat_vedio_right");
        Log.d("TAG", "chat_video_right_" + right_videoUri);

        left_videoUri=intent.getStringExtra("chat_vedio_left");
        Log.d("TAG", "chat_video_left_" + left_videoUri);*/

        videoUri = "https://s3.ca-central-1.amazonaws.com/codingwithmitch/media/VideoPlayerRecyclerView/Sending+Data+to+a+New+Activity+with+Intent+Extras.mp4";

        mExoplayerVideoView = findViewById(R.id.videoExoPlayerVideoPlaying);
        mSpinnerVideo = findViewById(R.id.spinnerExoPlayerVideoPlaying);


        mImgViewFullScreen = mExoplayerVideoView.findViewById(R.id.exo_fullscreen_icon);

        mImgViewFullScreen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (fullscreen) {
                    mImgViewFullScreen.setImageDrawable(ContextCompat.getDrawable(ScrCertificationCourseDetails.this, R.drawable.ic_fullscreen_expand));
                    getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_VISIBLE);
                    if (getSupportActionBar() != null) {
                        getSupportActionBar().show();
                    }
                    setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
                    RelativeLayout.LayoutParams params = (RelativeLayout.LayoutParams) mExoplayerVideoView.getLayoutParams();
                    params.width = params.MATCH_PARENT;
                    params.height = (int) (200 * getApplicationContext().getResources().getDisplayMetrics().density);
                    mExoplayerVideoView.setLayoutParams(params);
                    fullscreen = false;
                } else {
                    mImgViewFullScreen.setImageDrawable(ContextCompat.getDrawable(ScrCertificationCourseDetails.this, R.drawable.ic_fullscreen_skrink));
                    getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_FULLSCREEN
                            | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY
                            | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION);
                    if (getSupportActionBar() != null) {
                        getSupportActionBar().hide();
                    }
                    setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
                    RelativeLayout.LayoutParams params = (RelativeLayout.LayoutParams) mExoplayerVideoView.getLayoutParams();
                    params.width = params.MATCH_PARENT;
                    params.height = params.MATCH_PARENT;
                    mExoplayerVideoView.setLayoutParams(params);
                    fullscreen = true;
                }

            }
        });

    }

    @Override
    public boolean onSupportNavigateUp() {
        super.onBackPressed();
        releasePlayer();
        finish();
        return true;
    }

    public void initUi()
    {

        bt_buy_course=findViewById(R.id.bt_buy_course);
        bt_buy_course.setOnClickListener(this);

    }

    private void showLogin_signUp_Dialog() {

        Dialog dialog = new Dialog(this);
        dialog.setContentView(R.layout.dialog_login_signup);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(android.graphics.Color.TRANSPARENT));
        Window window = dialog.getWindow();
        window.setLayout(WindowManager.LayoutParams.MATCH_PARENT, WindowManager.LayoutParams.WRAP_CONTENT);
        Button bt_login = dialog.findViewById(R.id.bt_login);
        TextView tv_cancel=dialog.findViewById(R.id.tv_cancel);
        bt_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent=new Intent(ScrCertificationCourseDetails.this,ScrLogin.class);
                if (courses.getType().equals(Constants.FREE_COURSE))
                {
                    intent.putExtra("type",Constants.FREE_COURSE);
                }else {
                    intent.putExtra("type",Constants.BUY_COURSE);
                }
                startActivity(intent);
            }
        });
        dialog.setCancelable(false);
        dialog.show();

        tv_cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.dismiss();
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();

        initializePlayer();

        /*if (Objects.requireNonNull(intent.getExtras()).containsKey("chat_vedio_right")) {
            if (right_videoUri == null) {
                Log.d("TAG", "chat_video_right" + right_videoUri);
                return;
            }
            buildMediaSource(Uri.parse(right_videoUri));
        } else if (intent.getExtras().containsKey("chat_vedio_left")){
            if (left_videoUri == null) {
                Log.d("TAG", "chat_video_left" + left_videoUri);
                return;
            }
            buildMediaSource(Uri.parse(left_videoUri));
        }
*/
        if (videoUri==null)
        {
            Log.d("TAG", "vedio_uir" + videoUri);
            return;
        }buildMediaSource(Uri.parse(videoUri));
    }

    @Override
    protected void onResume() {
        super.onResume();

        resumePlayer();
    }

    @Override
    protected void onPause() {
        super.onPause();

        Log.i(TAG, "Paused : Unregistered broacast receiver");
        pausePlayer();
    }

    @Override
    protected void onStop() {
        super.onStop();

        releasePlayer();
    }



    private void initializePlayer() {

        if (player == null) {
            // 1. Create a default TrackSelector

            LoadControl loadControl = new DefaultLoadControl(
                    new DefaultAllocator(true, 16),
                    VideoPlayerConfig.MIN_BUFFER_DURATION,
                    VideoPlayerConfig.MAX_BUFFER_DURATION,
                    VideoPlayerConfig.MIN_PLAYBACK_START_BUFFER,
                    VideoPlayerConfig.MIN_PLAYBACK_RESUME_BUFFER, -1, true);

            BandwidthMeter bandwidthMeter = new DefaultBandwidthMeter();
            TrackSelection.Factory videoTrackSelectionFactory = new AdaptiveTrackSelection.Factory(bandwidthMeter);

            TrackSelector trackSelector = new DefaultTrackSelector(videoTrackSelectionFactory);

            // 2. Create the player
            player = ExoPlayerFactory.newSimpleInstance(new DefaultRenderersFactory(this), trackSelector, loadControl);

            mExoplayerVideoView.setUseController(true);

            mExoplayerVideoView.setPlayer(player);

        }

    }


    private void buildMediaSource(Uri mUri) {
        // Measures bandwidth during playback. Can be null if not required.
        DefaultBandwidthMeter bandwidthMeter = new DefaultBandwidthMeter();
        // Produces DataSource instances through which media data is loaded.
        DataSource.Factory dataSourceFactory = new DefaultDataSourceFactory(this, Util.getUserAgent(this, this.getString(R.string.app_name)), bandwidthMeter);
        // This is the MediaSource representing the media to be played.
        MediaSource videoSource = new ExtractorMediaSource.Factory(dataSourceFactory).createMediaSource(mUri);
        // Prepare the player with the source.

        //Toast.makeText(mContext, "Player Duration"+player.getDuration(), Toast.LENGTH_SHORT).show();

        player.prepare(videoSource);
        player.setPlayWhenReady(false);
        player.addListener(this);

    }

    private void releasePlayer() {
        if (player != null) {
            player.release();
            player = null;
        }
    }

    private void pausePlayer() {
        if (player != null) {
            player.setPlayWhenReady(false);
            player.getPlaybackState();
        }
    }

    private void resumePlayer() {
        if (player != null) {
            player.setPlayWhenReady(true);
            player.getPlaybackState();
        }
    }


    @Override
    public void onTimelineChanged(Timeline timeline, Object manifest, int reason) {

    }

    @Override
    public void onTracksChanged(TrackGroupArray trackGroups, TrackSelectionArray trackSelections) {

    }

    @Override
    public void onLoadingChanged(boolean isLoading) {

    }

    @Override
    public void onPlayerStateChanged(boolean playWhenReady, int playbackState) {

        switch (playbackState) {

            case Player.STATE_BUFFERING:
                mSpinnerVideo.setVisibility(View.VISIBLE);
                break;
            case Player.STATE_ENDED:
                // Activate the force enable
                break;
            case Player.STATE_IDLE:

                break;
            case Player.STATE_READY:
                mSpinnerVideo.setVisibility(View.GONE);

                break;
            default:
                // status = PlaybackStatus.IDLE;
                break;
        }
    }


    @Override
    public void onRepeatModeChanged(int repeatMode) {

    }

    @Override
    public void onShuffleModeEnabledChanged(boolean shuffleModeEnabled) {

    }

    @Override
    public void onPlayerError(ExoPlaybackException error) {

    }

    @Override
    public void onPositionDiscontinuity(int reason) {

    }

    @Override
    public void onPlaybackParametersChanged(PlaybackParameters playbackParameters) {

    }

    @Override
    public void onSeekProcessed() {

    }


    @Override
    public void onClick(View view) {
        switch (view.getId())
        {
            case R.id.bt_buy_course:
                showLogin_signUp_Dialog();
                break;
        }
    }
}
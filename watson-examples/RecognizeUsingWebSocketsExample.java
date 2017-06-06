/*
 * Copyright 2017 IBM Corp. All Rights Reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except in compliance with
 * the License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License is distributed on
 * an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the License for the
 * specific language governing permissions and limitations under the License.
 */

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

import com.ibm.watson.developer_cloud.http.HttpMediaType;
import com.ibm.watson.developer_cloud.speech_to_text.v1.SpeechToText;
import com.ibm.watson.developer_cloud.speech_to_text.v1.model.RecognizeOptions;
import com.ibm.watson.developer_cloud.speech_to_text.v1.model.SpeechResults;
import com.ibm.watson.developer_cloud.speech_to_text.v1.websocket.BaseRecognizeCallback;

/**
 * Recognize using WebSockets a sample wav file and print the transcript into the console output.
 */
public class RecognizeUsingWebSocketsExample {
  private static CountDownLatch lock = new CountDownLatch(1);

  public static void main(String[] args) throws FileNotFoundException, InterruptedException {
    SpeechToText service = new SpeechToText();
    service.setUsernameAndPassword("b5821638-269d-46d9-aa63-3d6104af149c", "EAVRIp5CEcIr");

    FileInputStream audio = new FileInputStream("test3.wav");

    RecognizeOptions options = new RecognizeOptions.Builder().continuous(true).interimResults(true)
        .contentType(HttpMediaType.AUDIO_WAV).timestamps(true).inactivityTimeout(Integer.MAX_VALUE).build();

    service.recognizeUsingWebSocket(audio, options, new BaseRecognizeCallback() {
      @Override
      public void onTranscription(SpeechResults speechResults) {
        System.out.println(speechResults);
        System.out.println("recognized");
      }

      @Override
      public void onDisconnected() {
    	  System.out.println("DISCONNECTED");
        lock.countDown();
      }
    });

    lock.await(1, TimeUnit.MINUTES);
  }
}

package com.github.instagram4j.Instagram4J.requests.music;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.github.instagram4j.Instagram4J.IGClient;
import com.github.instagram4j.Instagram4J.models.IGPayload;
import com.github.instagram4j.Instagram4J.requests.IGPostRequest;
import com.github.instagram4j.Instagram4J.responses.music.IGMusicTrackResponse;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@AllArgsConstructor
public class IGMusicSearchRequest extends IGPostRequest<IGMusicTrackResponse> {
    @NonNull
    private String _query;
    private String _cursor = "0";
    
    @Override
    protected IGPayload getPayload(IGClient client) {
        return new IGMusicQueryPayload(client.getSessionId(), _cursor, _query);
    }

    @Override
    public String path() {
        return "music/search/";
    }

    @Override
    public Class<IGMusicTrackResponse> getResponseType() {
        return IGMusicTrackResponse.class;
    }
    
    @Data
    @RequiredArgsConstructor
    @AllArgsConstructor
    @JsonInclude(Include.NON_NULL)
    protected static class IGMusicQueryPayload extends IGPayload {
        @NonNull
        private String browse_session_id;
        @NonNull
        private String cursor;
        private String q;
    }
    
}
/*
 * Copyright (c) 2023 Bernhard Haumacher et al. All Rights Reserved.
 */
package org.mjsip.ua.streamer;

import org.mjsip.media.AudioStreamer;
import org.mjsip.media.FlowSpec;
import org.mjsip.media.MediaStreamer;
import org.mjsip.media.StreamerOptions;
import org.mjsip.media.rx.AudioReceiver;
import org.mjsip.media.tx.AudioTransmitter;
import org.mjsip.ua.MediaConfig;

/**
 * {@link StreamerFactory} creating an {@link AudioStreamer} based on {@link StreamerOptions},
 * {@link AudioReceiver} and {@link AudioTransmitter}.
 */
public class DefaultStreamerFactory implements StreamerFactory {

	private final AudioReceiver _rx;
	private final AudioTransmitter _tx;
	private final StreamerOptions _options;

	/** 
	 * Creates a {@link DefaultStreamerFactory}.
	 */
	public DefaultStreamerFactory(StreamerOptions options, AudioReceiver rx, AudioTransmitter tx) {
		_options = options;
		_rx = rx;
		_tx = tx;
	}

	@Override
	public MediaStreamer createMediaStreamer(FlowSpec flow_spec, MediaConfig mediaConfig) {
		return new AudioStreamer(flow_spec, _tx, _rx, _options);
	}

}

package test.assignment.schedule;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import test.assignment.service.impl.ProcessInputFiles;

public class CollectionCrossCheckEngine {

	public static void main(String[] args) {

		ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);
		Runnable runnable = new Runnable() {
			@Override
			public void run() {
				ProcessInputFiles.processOrders();
			}
		};
		scheduler.scheduleAtFixedRate(runnable, getInitialDelay(), 24 * 60 * 60, TimeUnit.SECONDS);

		/*
		 * ExecutorService es = Executors.newSingleThreadExecutor();
		 * es.submit(runnable);
		 */
	}

	private static long getInitialDelay() {
		LocalDateTime localNow = LocalDateTime.now();
		ZoneId currentZone = ZoneId.of("Asia/Kolkata");
		ZonedDateTime zonedNow = ZonedDateTime.of(localNow, currentZone);
		ZonedDateTime zonedNext;
		zonedNext = zonedNow.withHour(23).withMinute(59).withSecond(0); // TODO move to properties
		if (zonedNow.compareTo(zonedNext) > 0)
			zonedNext = zonedNext.plusDays(1);

		Duration duration = Duration.between(zonedNow, zonedNext);
		long initalDelay = duration.getSeconds();
		return initalDelay;
	}

}

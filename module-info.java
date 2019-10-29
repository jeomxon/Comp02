module Comp2_JavaFX {
	exports application;
	exports lab08.practice02;
	exports lab08.practice03;
	exports lab08.hw01;
	exports lab09.prtc01;
	exports lab09.prtc02;
	exports lab09.prtc03;
	exports lab09.hw01;
	exports lab09.hw02;
	
	requires javafx.controls;
	requires javafx.fxml;
	requires javafx.graphics;
	
	opens lab09.prtc02;
	opens lab09.prtc03;
	opens lab09.hw01;
	opens lab09.hw02;
}
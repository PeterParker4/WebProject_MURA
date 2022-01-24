<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<script type="text/javascript">
class FancyButton extends React.Component {
	  render() {
	    // Mask id and styling
	    // need unique id's for multiple buttons
	    const maskId = 'mask_1';
	    const maskStyle = '#fancy-masked-element_' + maskId + ' { mask: url(#' + maskId + '); -webkit-mask: url(#' + maskId + ')}';

	    const buttonStyle = {
	      width: this.props.width,
	      height: this.props.height };


	    const fancyFrontStyle = {
	      transform: 'rotateX(0deg) translateZ(' + this.props.height / 2 + 'px )' };


	    const fancyBackStyle = {
	      transform: 'rotateX(90deg) translateZ( ' + this.props.height / 2 + 'px )' };


	    // SVG attributes
	    const textTransform = 'matrix(1 0 0 1 ' + this.props.width / 2 + ' ' + this.props.height / 1.6 + ')';
	    const viewBox = '0 0 ' + this.props.width + ' ' + this.props.height;

	    return /*#__PURE__*/(
	      React.createElement("div", { className: "fancy-button",
	        style: buttonStyle,
	        ref: "fancyButton" }, /*#__PURE__*/
	      React.createElement("div", { className: "fancy-flipper" }, /*#__PURE__*/
	      React.createElement("div", { className: "fancy-front", style: fancyFrontStyle }, /*#__PURE__*/
	      React.createElement("svg", {
	        height: this.props.height,
	        width: this.props.width,
	        viewBox: viewBox }, /*#__PURE__*/
	      React.createElement("defs", null, /*#__PURE__*/
	      React.createElement("mask", { id: maskId }, /*#__PURE__*/
	      React.createElement("rect", { width: "100%", height: "100%", fill: "#FFFFFF" }), /*#__PURE__*/
	      React.createElement("text", { className: "mask-text button-text", fill: "#000000", transform: textTransform, fontFamily: "'intro_regular'", fontSize: this.props.fontSize, width: "100%", textAnchor: "middle", letterSpacing: "1" }, this.props.buttonText))), /*#__PURE__*/


	      React.createElement("style", null,
	      maskStyle), /*#__PURE__*/

	      React.createElement("rect", { id: 'fancy-masked-element_' + maskId, fill: this.props.color, width: "100%", height: "100%" }))), /*#__PURE__*/


	      React.createElement("div", { className: "fancy-back", style: fancyBackStyle }, /*#__PURE__*/
	      React.createElement("svg", {
	        height: this.props.height,
	        width: this.props.width,
	        viewBox: viewBox }, /*#__PURE__*/
	      React.createElement("rect", { stroke: this.props.color,
	        strokeWidth: this.props.borderWidth,
	        fill: "transparent",
	        width: "100%",
	        height: "100%" }), /*#__PURE__*/
	      React.createElement("text", { className: "button-text", transform: textTransform, fill: this.props.color, fontFamily: "'intro_regular'", fontSize: this.props.fontSize, textAnchor: "middle", letterSpacing: "1" }, this.props.buttonText))))));





	  }}


	FancyButton.defaultProps = {
	  color: '#FFFFFF',
	  width: 410,
	  height: 100,
	  fontSize: 40,
	  borderWidth: 15,
	  buttonText: 'FANCY BUTTON' };


	React.render( /*#__PURE__*/React.createElement(FancyButton, null), document.getElementById('app'));
</script>
<meta charset="UTF-8">
<title></title>
<style type="text/css">


html,
body {
  height: 100%;
  overflow: hidden;
}

body {
  color: #6699CC;
  font-size: 22px;
  font-weight: bold;
  text-align: center;
  -webkit-font-smoothing: antialiased;
  display: flex;
  align-items: center;
  justify-content: center;
  background-color: #C594C5;
  background-size: cover;
  background-position: center;
  background-image: linear-gradient(rgba(173, 216, 230, 0.4), rgba(221, 160, 221, 0.4)), url("https://i.imgsafe.org/1fee5c9.jpg");
}

.fancy-button {
  position: relative;
  display: block;
  cursor: pointer;
  perspective: 1800px;
}
.fancy-button .fancy-flipper {
  position: absolute;
  top: 0;
  right: 0;
  bottom: 0;
  left: 0;
  transform-style: preserve-3d;
  transform: rotateX(-90deg);
  transition: transform 0.3s ease;
}
.fancy-button .fancy-front,
.fancy-button .fancy-back {
  position: absolute;
  top: 0;
  right: 0;
  bottom: 0;
  left: 0;
  -webkit-backface-visibility: hidden;
          backface-visibility: hidden;
}
.fancy-button .fancy-front svg,
.fancy-button .fancy-back svg {
  display: block;
}
.fancy-button:hover .fancy-flipper {
  transform: rotateX(0deg);
}
.fancy-button:active .fancy-flipper {
  transform: rotateX(0deg) scale(0.95);
  transition: transform 0.05s ease;
}
.fancy-button .button-text {
  letter-spacing: 0.01em;
  font-family: Futura, "Helvetica Neue", Helvetica, sans-serif;
}
</style>
</head>
<body>
<h1>Hover</h1>
<div id="app">
<p>
  <button class="fancy-button">Hover me</button>
  <button class="btn btn-5">Hover me</button>
</p>
<p>
  <button class="btn btn-1">Hover me</button>
  <button class="btn btn-4">Hover me</button>
</p>
<p>
  <button class="btn btn-2">Hover me</button>
  <button class="btn btn-6">Hover me</button>
</p>
</div>
</body>
</html>
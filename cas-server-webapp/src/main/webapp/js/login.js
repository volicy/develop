define( ['jquery'],function () {

  var $user = $('.user-name');
  var $password = $( '.pass-word' );
  var $login = $( '.logging' );
  var $form = $( '#fm1' );
  var $mess = $( '.error-mess' );
  var $mess_txt = $mess.find( '#error-message' );

  function init () {
    $user.bind( 'keyup', function ( evt ) {
      var et = evt || window.event;
      inputFocus( et );
    } );

    $password.bind( 'keyup', function ( evt ) {
      var et = evt || window.event;
      inputFocus( et );
    } );
    
    $(".pass-word").blur(function(){
    	var username=$("#username").val();
    	var password=$("#password").val();
    	if(username && password){
    		$mess.hide();
    	}
    });

    $login.bind( 'click', function () {
      if ( $user.val() == '' )
      {
        $mess.show();
        $mess_txt.html( '请输入用户名！' );
      }
      else if ( $password.val() == '' )
      {
        $mess.show();
        $mess_txt.html( '请输入密码！' );
      }
      else
      {
        $mess.hide();
        if(!sgr){
        	alert('请输入密码！');
        }
        $form.submit();
      }
    } );
  }


  function inputFocus ( et ) {
    var keyCode = et.keyCode;

    if ( keyCode == 13 )
    {
      if ( $user.val() == '' )
      {
        $user.get( 0 ).focus();
      }
      else if ( $password.val() == '' )
      {
        $password.get( 0 ).focus();
      }
      else
      {
        $form.submit();
      }
    }
  }

  return {
    init: init
  }
});
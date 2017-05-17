function result(fir,op,sec)
{
var second=parseInt(sec);
var res=parseInt(fir);
switch(op)
	{
	case '+': res+=second; break;
	case '-': res-=second; break;
	case '/': res/=second; break;
	case '*': res*=second; break;
	default: break;
	}
	return res;
}
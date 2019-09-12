local Object = require"Object";

local libjvm = require"java.jvm";

local hashCode;
local getClass;
local wait;
local notify;
local notifyAll;


function Object.Java_java_lang_Object_registerNatives(env,cl,o)
  local natives = {
    hashCode=hashCode,
    getClass=getClass,
    wait0=wait,
    notify0=notify,
    notifyAll0=notifyAll
  }
end
local Object = {};

local libjvm = require"java.jvm";

local hashCode;
local getClass;
local wait;
local notify;
local notifyAll;
local clone;


function Object.Java_java_lang_Object_registerNatives(env,cl)
  local natives = {
    hashCode=hashCode,
    getClass=getClass,
    wait0=wait,
    notify0=notify,
    notifyAll0=notifyAll,
    clone=clone
  }
  env.RegisterNatives(cl,natives);
end

local function hashCode(env,o)
  return libjvm.IdentityHashCode(libjvm.DerefObject(o));
end

local function getClass(env,o)
  return libjvm.toJNIObject(libjvm.ClassObject(libjvm.GetClass(libjvm.DerefObject(o))));
end

return Object;
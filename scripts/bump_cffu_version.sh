#!/bin/bash
set -eEuo pipefail
# adjust current dir to script dir
cd "$(dirname "$(readlink -f "$0")")"

source bash-buddy/lib/trap_error_info.sh
source bash-buddy/lib/common_utils.sh
source bash-buddy/lib/java_build_utils.sh

readonly nl=$'\n' # new line

# shellcheck disable=SC2154
[ $# -ne 1 ] && cu::die "need only 1 argument for version!$nl${nl}usage:$nl $0 x.y.z"
readonly bump_version="$1"

cd ..

jvb::mvn_cmd \
  org.codehaus.mojo:versions-maven-plugin:2.15.0:set \
  -DgenerateBackupPoms=false \
  -DprocessAllModules=true \
  -DnewVersion="$bump_version"
package com.twitter.gizzard
package thrift
package conversions

import conversions.ShardId._


object LinkInfo {
  class RichShardingLinkInfo(linkInfo: shards.LinkInfo) {
    def toThrift = new thrift.LinkInfo(linkInfo.upId.toThrift, linkInfo.downId.toThrift, linkInfo.weight)
  }
  implicit def shardingLinkInfoToRichShardingLinkInfo(linkInfo: shards.LinkInfo) = new RichShardingLinkInfo(linkInfo)

  class RichThriftLinkInfo(linkInfo: thrift.LinkInfo) {
    def fromThrift = new shards.LinkInfo(linkInfo.up_id.fromThrift, linkInfo.down_id.fromThrift, linkInfo.weight)
  }
  implicit def thriftLinkInfoToRichThriftLinkInfo(linkInfo: thrift.LinkInfo) = new RichThriftLinkInfo(linkInfo)
}

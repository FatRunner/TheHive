package org.thp.thehive.models

import java.util.Date

import org.thp.scalligraph.models.Entity
import org.thp.scalligraph.{BuildEdgeEntity, BuildVertexEntity, EntityId}

@BuildEdgeEntity[Log, Attachment]
case class LogAttachment()

@BuildVertexEntity
case class Log(message: String, date: Date)

case class RichLog(log: Log with Entity, attachments: Seq[Attachment with Entity]) {
  def _id: EntityId              = log._id
  def _createdBy: String         = log._createdBy
  def _updatedBy: Option[String] = log._updatedBy
  def _createdAt: Date           = log._createdAt
  def _updatedAt: Option[Date]   = log._updatedAt
  def date: Date                 = log.date
  def message: String            = log.message
}
